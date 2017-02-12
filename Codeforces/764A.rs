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
    read_line!(call_interval;i32,come_interval;i32,day_length;i32);
    let mut min = come_interval;
    let mut count = 0;
    while min <= day_length {
        if min % call_interval == 0 {
            count += 1;
        }
        min += come_interval;
    }
    println!("{}", count);
}