var fs = require('fs');

const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString();
const N = parseInt(input);

const stars = [];

for(let i = 0; i < N; i++) {
  stars[i] = []
  for(let j = 0; j < N; j++) {
    stars[i][j] = '*'
  }
}

const solve = (_x_start, _y_start, _num) => {
  const thirdNum = _num / 3;
  for(let i = _x_start + thirdNum; i < _x_start + (2 * thirdNum); i++) {
    for(let j = _y_start + thirdNum; j < _y_start + (2 * thirdNum); j++) {
      stars[i][j] = ' ';
    }
  }

  if(_num > 3) {
    for(let i = _x_start; i < _x_start + _num; i += thirdNum) {
      for(let j = _y_start; j < _y_start + _num; j+= thirdNum) {
        if(i === _x_start + thirdNum && j === _y_start + thirdNum) {
          continue;
        }
        solve(i, j, thirdNum);
      }
    }
  }
};

solve(0, 0, N);

stars.forEach(line => {
  let answer = ''
  line.forEach(star => {
    answer += star
  })
  console.log(answer)
})