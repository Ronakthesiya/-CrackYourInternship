// class Solution {
//     public String intToRoman(int num) {
//         String[] ones= {"","I","II","III","IV","V","VI","VII","VIII","IX"};
//         String[] tens= {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
//         String[] hrns= {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
//         String[] ths={"","M","MM","MMM"};
        
//         return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
//     }
// }


class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String []str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int i = 0; i < 13; i++)
        {
            while(num >= arr[i])
            {
                num -= arr[i];
                sb.append(str[i]); 
            }
        }
        return sb.toString();
    }
}