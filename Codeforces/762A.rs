use std::collections::LinkedList;

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
    read_line!(k;u64, n;u64);
    let mut divisors = LinkedList::new();
    let mut i = (k as f64).sqrt() as u64;
    if i * i == k {
        divisors.push_back(i);
        i -= 1;
    }
    while i >= 1 {
        if k % i == 0 {
            divisors.push_front(i);
            divisors.push_back(k / i);
        }
        i -= 1;
    }
    if n > divisors.len() as u64 {
        println!("-1");
    } else {
        for (idx, divisor) in divisors.iter().enumerate() {
            if idx as u64 == n - 1 {
                println!("{}", divisor);
            }
        }
    }
}