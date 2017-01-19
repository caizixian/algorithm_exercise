use std::io::stdin;

fn main() {
    let mut input_line = String::new();
    stdin().read_line(&mut input_line).unwrap();
    let mut input_iter = input_line.
        split_whitespace().
        map(|x| x.parse::<usize>().unwrap());

    let flower_count = input_iter.next().unwrap();
    let subarray_count = input_iter.next().unwrap();

    let mut sum_range = [0; 101];
    let mut input_line = String::new();
    stdin().read_line(&mut input_line).unwrap();
    let mut input_iter = input_line.
        split_whitespace().
        map(|x| x.parse::<i32>().unwrap());

    for i in 1..(flower_count + 1) {
        sum_range[i] = sum_range[i - 1] + input_iter.next().unwrap();
    }

    let mut result = 0;

    for _ in 1..(subarray_count + 1) {
        let mut input_line = String::new();
        stdin().read_line(&mut input_line).unwrap();
        let mut input_iter = input_line.
            split_whitespace().
            map(|x| x.parse::<usize>().unwrap());
        let left = input_iter.next().unwrap();
        let right = input_iter.next().unwrap();
        let happiness = sum_range[right] - sum_range[left - 1];
        if happiness > 0 {
            result += happiness;
        }
    }

    println!("{}", result);
}