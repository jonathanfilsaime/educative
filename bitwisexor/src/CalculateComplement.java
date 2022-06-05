import java.lang.Math;

class CalculateComplement {
    public static int bitwiseComplement(int n) {
        // TODO: Write your code here
        int bitCount = 0;
        int num = n;
        while (num > 0) {
            bitCount++;
            num = num >> 1;
        }

        int  allBitSet = (int) Math.pow(2, bitCount) - 1;

        return n ^ allBitSet;

    }

    public static void main( String args[] ) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }
}