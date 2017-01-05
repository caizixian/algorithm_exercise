use std::io;

fn main() {
    let mut input_str = String::new();
    io::stdin().read_line(&mut input_str).unwrap();

    let mut iter = input_str.trim().split_whitespace();
    let i: u64 = iter.next().unwrap().parse().unwrap();

    match i {
        1 => println!("{}", -1),
        _ => println!("{} {} {}", i, i + 1, i * (i + 1))
    };
}
