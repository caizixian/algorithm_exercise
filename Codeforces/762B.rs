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

enum MousePort {
    USB,
    PS2
}

fn main() {
    read_line!(usb_only;usize, ps2_only;usize, both_ports;usize);
    let mut usb_only = usb_only;
    let mut ps2_only = ps2_only;
    let mut both_ports = both_ports;
    read_line!(mice_cnt;usize);
    let mut mice = Vec::with_capacity(mice_cnt);
    for _ in 0..mice_cnt {
        read_line!(price;u32, ty;String);
        match ty.as_ref() {
            "USB" => mice.push((price, MousePort::USB)),
            "PS/2" => mice.push((price, MousePort::PS2)),
            _ => unreachable!()
        }
    }

    mice.sort_by_key(|k| k.0);

    let need_to_purchase = usb_only + ps2_only + both_ports;
    let mut total_price: u64 = 0;
    let mut purchased = 0;

    for (price, ty) in mice {
        if purchased == need_to_purchase {
            break;
        }
        match ty {
            MousePort::USB => {
                if usb_only > 0 {
                    usb_only -= 1
                } else if both_ports > 0 {
                    both_ports -= 1
                } else {
                    continue
                }
            },
            MousePort::PS2 => {
                if ps2_only > 0 {
                    ps2_only -= 1
                } else if both_ports > 0 {
                    both_ports -= 1
                } else {
                    continue
                }
            }
        }
        total_price += price as u64;
        purchased += 1;
    }

    println!("{} {}", purchased, total_price);
}