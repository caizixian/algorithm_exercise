use std::collections::LinkedList;
use std::iter::FromIterator;

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

fn trivial_coincide(a_barrier: &LinkedList<i32>, b_barrier: &LinkedList<i32>) -> bool {
    let iter = a_barrier.iter().zip(b_barrier.iter());
    let mut difference = None;
    for (a, b) in iter {
        match difference {
            Some(diff) => {
                if (*a - *b) != diff {
                    return false;
                }
            },
            None => {
                difference = Some(*a - *b);
            }
        }
    }
    return true;
}

fn main() {
    read_line!(barriers;i32,track_length;i32);
    read_line!(vec,i32,a_barrier);
    read_line!(vec,i32,b_barrier);
    let a_barrier = LinkedList::from_iter(a_barrier.into_iter());
    let mut b_barrier = LinkedList::from_iter(b_barrier.into_iter());
    for _ in 0..barriers {
        let extend_front = b_barrier.pop_front().unwrap() + track_length;
        b_barrier.push_back(extend_front);
        if trivial_coincide(&a_barrier, &b_barrier) {
            println!("YES");
            return;
        }
    }
    println!("NO");
}