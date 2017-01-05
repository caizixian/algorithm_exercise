use std::io;

fn main() {
    let mut input_str = String::new();
    io::stdin().read_line(&mut input_str).unwrap();
    let mut iter = input_str.trim().split_whitespace();
    let airport_count = iter.next().unwrap().parse::<usize>().unwrap();
    let start = iter.next().unwrap().parse::<usize>().unwrap() - 1;
    let end = iter.next().unwrap().parse::<usize>().unwrap() - 1;

    let mut airports = Vec::with_capacity(airport_count);

    let mut input_str = String::new();
    io::stdin().read_line(&mut input_str).unwrap();
    for ch in input_str.chars() {
        if ch == '1' {
            airports.push(true);
        } else {
            airports.push(false);
        }
    }

    if airports[start] == airports[end] {
        println!("{}", 0);
    } else {
        println!("{}", 1);
    }
}
