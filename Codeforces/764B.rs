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
    read_line!(cube_count;usize);
    read_line!(vec,i32,cubes);
    let mid = cube_count / 2;
    for i in 0..cube_count {
        let mut reversed = true;
        if i < mid {
            reversed = i % 2 == 0;
        } else {
            reversed = (cube_count - 1 - i) % 2 == 0;
        }
        if reversed {
            print!("{} ", cubes[cube_count - 1 - i]);
        } else {
            print!("{} ", cubes[i]);
        }
    }
}