package prog.study;


public class Question4 {

    static char[] encode(char[] input, int size){
        char[] result = new char[input.length];
        int resultCount = 0;
        for (int i=0; i < size; i++) {
            if (input[i] == ' ') {
                result[resultCount++] = '%';
                result[resultCount++] = '2';
                result[resultCount++] = '0';
            }else{
                result[resultCount++] = input[i];
            }
        }
        return result;
    }

    static void encodeInPlace(char[] input, int size){
        int spaceCount = 0, newLenght, i;
        for (i=0; i < size; i++){
            if (input[i] == ' '){
                spaceCount++;
            }
        }

        newLenght = size + spaceCount * 2;

        input[newLenght] = '\0'; // nao deu pra entender bem o que isto significou... nao tinhamos usado este caracter de fim de string

        for (i= size - 1 ;i >= 0; i--){
            if (input[i] == ' '){
                input[newLenght-1] = '0';
                input[newLenght-2] = '2';
                input[newLenght-3] = '%';

                newLenght = newLenght - 3;
            }else {
                input[newLenght-1] = input[i];
                newLenght = newLenght - 1;
            }
        }
    }

    public static void main(String[] args) {
        char[] input = "Mr John Smikkkkkkk kkkkkkaljnafafla nkjanslksjanfl kajn th             ".toCharArray();
        int relevantSize = 58;
        long start = System.nanoTime();
        System.out.println(encode(input,relevantSize));
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start));
        System.out.println(input);
        start = System.nanoTime();
        encodeInPlace(input,relevantSize);
        System.out.println(input);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start));
    }
}

