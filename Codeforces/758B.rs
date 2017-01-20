use std::collections::HashMap;
use std::io;

fn main() {
    const BLOBS: &'static str = "RBYG";

    let mut failure_count: HashMap<usize, usize> = HashMap::new();
    let mut pattern_position: HashMap<char, usize> = HashMap::new();

    let mut garland = String::new();

    io::stdin().read_line(&mut garland).unwrap();

    for (index, blob) in garland.chars().enumerate() {
        let position = index % BLOBS.len();
        match blob {
            '!' => {
                *failure_count.entry(position).or_insert(0) += 1;
            },
            x => {
                pattern_position.insert(x, position);
            }
        }
    }

    for blob in BLOBS.chars() {
        match pattern_position.get(&blob) {
            Some(position) => {
                print!("{} ", *failure_count.entry(*position).or_insert(0));
            },
            None => {
                println!("Cannot infer position of {} from input", blob);
            }
        }
    }
}