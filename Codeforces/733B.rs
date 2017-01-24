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
    read_line!(columns;i32);
    let mut column = Vec::new();
    for _ in 0..columns {
        read_line!(l;i32,r;i32);
        column.push((l, r));
    }
    let (l_sum, r_sum) = column.iter().fold((0, 0),
                                            |(l0, r0), &(l, r)| {
                                                (l0 + l, r0 + r)
                                            });
    let mut max_beauty = (l_sum - r_sum).abs();
    let mut col_flip = 0;
    for (idx, &(l, r)) in column.iter().enumerate() {
        let current_beauty = ((l_sum - l + r) - (r_sum - r + l)).abs();
        if current_beauty > max_beauty {
            col_flip = idx + 1;
            max_beauty = current_beauty;
        }
    }
    println!("{}", col_flip);
}