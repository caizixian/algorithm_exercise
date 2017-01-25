use std::cmp::Ordering;

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
    read_line!(input_line);
    read_line!(input_line);
    let sum = input_line.trim().chars().fold((0, 0), |acc, x| {
        match x {
            'A' => (acc.0 + 1, acc.1),
            'D' => (acc.0, acc.1 + 1),
            _ => unreachable!()
        }
    });
    match sum.0.cmp(&sum.1) {
        Ordering::Greater => println!("Anton"),
        Ordering::Equal => println!("Friendship"),
        Ordering::Less => println!("Danik")
    }
}