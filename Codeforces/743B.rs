use std::io;
use std::cmp::Ordering;

fn sequence_position(level: u32, idx: u64) -> u32 {
    match level {
        1 => 1,
        _ => {
            let half_length = 2_u64.pow(level - 1);
            match idx.cmp(&half_length) {
                Ordering::Less => sequence_position(level - 1, idx),
                Ordering::Equal => level,
                Ordering::Greater => sequence_position(level - 1, idx - half_length)
            }
        }
    }
}

fn main() {
    let mut input_str = String::new();
    io::stdin().read_line(&mut input_str).unwrap();

    let mut iter = input_str.trim().split_whitespace();
    let level: u32 = iter.next().unwrap().parse().unwrap();
    let position: u64 = iter.next().unwrap().parse().unwrap();

    println!("{}", sequence_position(level, position));
}
