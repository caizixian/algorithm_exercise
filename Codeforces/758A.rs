use std::io;
use std::cmp;

fn main() {
    io::stdin().read_line(&mut String::new()).unwrap();

    let mut welfare_input = String::new();
    io::stdin().read_line(&mut welfare_input).unwrap();

    let mut max_welfare = 0;
    let mut total_welfare = 0;
    let mut population = 0;

    for welfare in welfare_input.
        split_whitespace().
        map(|x| x.parse().unwrap()) {
        total_welfare += welfare;
        max_welfare = cmp::max(max_welfare, welfare);
        population += 1;
    }

    println!("{}", population * max_welfare - total_welfare);
}