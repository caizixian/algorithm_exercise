use std::io::stdin;
use std::cmp::min;

fn main() {
    let mut input_line = String::new();
    stdin().read_line(&mut input_line);

    let mut input_iter = input_line.
        split_whitespace().
        map(|x| x.parse::<u64>().unwrap());

    let owned = input_iter.next().unwrap();
    let price1 = input_iter.next().unwrap();
    let price2 = input_iter.next().unwrap();
    let price3 = input_iter.next().unwrap();

    if owned % 4 == 0 {
        // Already meet criteria
        println!("0");
        return;
    }

    let purchase = 4 - owned % 4;
    let result = match purchase {
        1 => min(price1, min(price3 * 3, price2 + price3)),
        2 => min(price2, min(price1 * 2, price3 * 2)),
        3 => min(price3, min(price1 * 3, price2 + price1)),
        _ => u64::max_value()
    };

    println!("{}", result);
}