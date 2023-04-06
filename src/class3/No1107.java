package class3;

import java.util.ArrayList;
import java.util.Scanner;

public class No1107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        RemoteControl remoteControl = new RemoteControl(N, M, scanner);

        int result = remoteControl.solve();

        System.out.println(result);
    }
}

class RemoteControl {
    int N, M;
    boolean[] buttons = new boolean[10];
    int errorBtnCount = 0;
    ArrayList<Integer> numbers = new ArrayList<>();

    boolean hasErrorBtn = false;
    ArrayList<Integer> smallNumList = new ArrayList<>();
    ArrayList<Integer> largeNumList = new ArrayList<>();
    int smallNum = 0;
    int largeNum = 0;

    int count = 0;
    int possibleSmallNum = 0;
    int possibleLargeNum = 0;


    RemoteControl(int N, int M, Scanner scanner) {
        this.N = N;
        this.M = M;

        for(int i = 0; i < M; i++) {
            buttons[scanner.nextInt()] = true;
            errorBtnCount++;
        }

        String NString = Integer.toString(N);

        for(int i = 0; i < NString.length(); i++){
            numbers.add(Integer.parseInt(NString.substring(i, i + 1)));
        }
    }

    public int solve(){
        count = 0;

        if(errorBtnCount == 10) {
            count = Math.abs(N - 100);
        } else {
            for(int i = 0; i < 10; i++) {
                if(!buttons[i]) {
                    possibleSmallNum = i;
                    break;
                }
            }

            for(int i = 9; i >= 0; i--) {
                if(!buttons[i]) {
                    possibleLargeNum = i;
                    break;
                }
            }

            for (int i = 0; i < numbers.size(); i++) {
                int currentNum = numbers.get(i);
                if (hasErrorBtn) {
                    largeNumList.add(possibleSmallNum);
                    smallNumList.add(possibleLargeNum);
                } else {
                    if(buttons[currentNum]) {
                        // 고장난 버튼
                        hasErrorBtn = true;

                        // 큰숫자 케이스
                        findLargeNum(i, currentNum);

                        // 작은숫자 케이스
                        findSmallNum(i, currentNum);
                    } else {
                        // 정상 버튼
                        smallNumList.add(currentNum);
                        largeNumList.add(currentNum);
                    }
                }
            }

            int smallNumCount = smallNumList.size();
            int largeNumCount = largeNumList.size();

            String smallNumStr = "";
            String largeNumStr = "";

            for(int i = 0; i < smallNumCount; i++) {
                smallNumStr += smallNumList.get(i);
            }

            for(int i = 0; i < largeNumCount; i++) {
                largeNumStr += largeNumList.get(i);
            }

            smallNum = smallNumStr.length() == 0 ? possibleSmallNum : Integer.parseInt(smallNumStr);
            largeNum = Integer.parseInt(largeNumStr);

            smallNumCount = Integer.toString(smallNum).length();
            largeNumCount = Integer.toString(largeNum).length();

            if(smallNum != N) {
                smallNumCount = smallNum < N ? smallNumCount + N - smallNum : Integer.MAX_VALUE;
                largeNumCount = largeNum > N ? largeNumCount + largeNum - N : Integer.MAX_VALUE;
            }

            count = smallNumCount > largeNumCount ? largeNumCount : smallNumCount;
            count = count < Math.abs(N - 100) ? count : Math.abs(N - 100);
        }

        return count;
    }

    private void findLargeNum(int currentIdx, int currentNum){
        if(currentNum < possibleLargeNum) {
            // 사용 가능한 큰 숫자의 버튼이 있을 때
            for(int num = currentNum; num <= possibleLargeNum; num++) {
                if(!buttons[num]) {
                    largeNumList.add(num);
                    break;
                }
            }
        } else {
            // 사용 가능한 큰 숫자의 버튼이 없을 때
            // 앞자리 숫자 조정
            currentIdx--;
            if(currentIdx >= 0) {
                int tempCount = 1;
                while(currentIdx >= 0) {
                    int tempNum = largeNumList.get(currentIdx);
                    if(tempNum < possibleLargeNum) {
                        tempNum++;
                        for(; tempNum <= possibleLargeNum; tempNum++) {
                            if(!buttons[tempNum]){
                                largeNumList.remove(currentIdx);
                                largeNumList.add(tempNum);
                                break;
                            }
                        }
                        break;
                    } else {
                        largeNumList.remove(currentIdx);
                        currentIdx--;
                        tempCount++;
                    }
                    if(currentIdx < 0)
                        break;
                }
                if(largeNumList.size() < 1 && possibleSmallNum == 0) {
                    for(int i = 1; i <= possibleLargeNum; i++) {
                        if(!buttons[i]) {
                            largeNumList.add(i);
                            tempCount--;
                            break;
                        }
                    }
                }

                for(int i = 0; i < tempCount; i++){
                    largeNumList.add(possibleSmallNum);
                }
            } else {
                if(possibleSmallNum == 0) {
                    for(int i = 1; i <= possibleLargeNum; i++) {
                        if(!buttons[i]) {
                            largeNumList.add(i);
                            break;
                        }
                    }
                } else{
                    largeNumList.add(possibleSmallNum);
                }
                largeNumList.add(possibleSmallNum);
            }
        }
    }

    private void findSmallNum(int currentIdx, int currentNum){
        if(currentNum > possibleSmallNum) {
            // 사용 가능한 작은 숫자의 버튼이 있을 때
            for(int num = currentNum; num >= possibleSmallNum; num--) {
                if(!buttons[num]) {
                    smallNumList.add(num);
                    break;
                }
            }
        } else {
            // 사용 가능한 작은 숫자의 버튼이 없을 때
            // 앞자리 숫자 조정
            currentIdx--;
            if(currentIdx >= 0) {
                int tempCount = 0;
                boolean hasPossibleSmaller = false;

                while(currentIdx >= 0) {
                    int tempNum = smallNumList.get(currentIdx);
                    if(tempNum > possibleSmallNum){
                        hasPossibleSmaller = true;
                        tempNum--;
                        for(; tempNum >= possibleSmallNum; tempNum--) {
                            if(!buttons[tempNum]) {
                                smallNumList.remove(currentIdx);
                                smallNumList.add(tempNum);
                                tempCount++;
                                break;
                            }
                        }
                        break;
                    } else {
                        smallNumList.remove(currentIdx);
                        tempCount++;
                        currentIdx--;
                    }
                    if(currentIdx < 0)
                        break;
                }


                    for(int i = 0; i < tempCount; i++) {
                        smallNumList.add(possibleLargeNum);
                    }

            }
        }
    }
}
