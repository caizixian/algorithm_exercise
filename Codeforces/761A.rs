macro_rules! read_line {
    ($v:ident) => {
        let mut temp = String::new();
        std::io::stdin().read_line(&mut temp).unwrap();
        let $v = temp;
    };
    (var, $t:ty, $($v:ident), *) => {
        read_line!(input_line);
        let mut iter = parse_token!($t, input_line);
        $(
            let $v = iter.next().unwrap();
        )*
    };
    (vec, $t:ty, $v:ident) => {
        read_line!(input_line);
        let iter = parse_token!($t, input_line);
        let $v: Vec<$t> = iter.collect();
    };
    ($($v:ident; $t:ty), *) => {
        read_line!(input_line);
        let mut iter = input_line.split_whitespace();
        $(
            let $v: $t = iter.next().unwrap().parse().unwrap();
        )*
    };
}

macro_rules! parse_token {
    ($t:ty, $e:expr) => {
        $e.split_whitespace().map(|x| x.parse::<$t>().unwrap());
    };
}

fn main() {
    read_line!(even;i64, odd;i64);
    if odd == 0 && even == 0 {
        println!("NO"); // There must be one staircase
        return
    }
    if (odd - even).abs() <= 1 {
        // Valid count
        println!("YES")
    } else {
        println!("NO")
    }
}