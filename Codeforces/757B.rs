use std::io;

fn factorization(num: u32, factor_count: &mut [u32]) {
    let mut num = num;
    let upper_bound = ((num as f64).sqrt().floor()) as u32;

    for i in 2..(upper_bound + 1) {
        if num % i == 0 {
            factor_count[i as usize] += 1;
        }
        while num % i == 0 {
            num /= i;
        }
    }
    if num > 1 {
        factor_count[num as usize] += 1
    }
}

fn main() {
    const MAX_SIZE: usize = 100010;

    let mut factor_count = [0u32; MAX_SIZE];

    let mut input_line = String::new();
    io::stdin().read_line(&mut input_line).unwrap();
    let mut input_line = String::new();
    io::stdin().read_line(&mut input_line).unwrap();

    for strength in input_line.split_whitespace() {
        factorization(strength.parse().unwrap(), &mut factor_count);
    }

    let (_, max_count) = factor_count.
        into_iter().
        enumerate().
        max_by_key(|tuple| tuple.1).
        unwrap();

    println!("{}", std::cmp::max(max_count, &1));
}