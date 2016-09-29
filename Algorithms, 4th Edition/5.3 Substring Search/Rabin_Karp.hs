import System.Process (readProcess)
import System.IO (getLine, putStrLn)
import Data.Char (ord, isAscii)
import Debug.Trace (trace)

charsetSize = 128

hash :: String->Int->Int
hash text largePrime =
    let calc oldHash charPoint = (charsetSize * oldHash + charPoint) `rem` largePrime
    in foldl calc 0 (map ord text)

updateHash :: Int->Char->Char->Int->Int->Int
updateHash oldHash oldLeadingChar newTrailingChar largePrime rm =
    let hashAfterLeadingRemoved = (oldHash+largePrime-rm*(ord oldLeadingChar) `rem` largePrime) `rem` largePrime
    in (hashAfterLeadingRemoved*charsetSize + ord newTrailingChar) `rem` largePrime

--subStringSearch patternLength initPatternHash text@(x:xs) initTextHash largePrime rm | trace ("subStringSearch " ++ show initPatternHash ++ " " ++ show initTextHash ++" "++ text) False = undefined
subStringSearch patternLength initPatternHash text@(x:xs) initTextHash largePrime rm
    | initTextHash==initPatternHash = True
    | patternLength >= length text = False -- Text should be no shorter than pattern
    | otherwise = let updatedTextHash = updateHash initTextHash x (text!!patternLength) largePrime rm
                  in subStringSearch patternLength initPatternHash xs updatedTextHash largePrime rm

powRem::Int->Int->Int->Int
powRem a 0 divider = 1
powRem a x divider = (a*(powRem a (x-1) divider)) `rem` divider

main = do
    largePrime <- fmap read (readProcess "openssl" ["prime", "-generate", "-bits", "12"] "") :: IO Int
    pattern <- getLine
    text <- getLine
    let rm = powRem charsetSize (length pattern -1) largePrime
    let result = if not (all isAscii pattern && all isAscii text)
        then False
        else subStringSearch (length pattern) initPatternHash text initTextHash largePrime rm where
            initPatternHash = hash pattern largePrime
            initTextHash = hash (take (length pattern) text) largePrime
    if result
        then putStrLn "Sucessfully matched."
        else putStrLn "Couldn't match."