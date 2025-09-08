public class hcn {
    private int x; 
    private int y; 

    public hcn(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getPerimeter() {
        return 2 * (x + y);
    }

  
    public int getArea() {
        return x * y;
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Vui lòng nhập 2 tham số: chiều dài và chiều rộng");
            return;
        }

        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);

 
            if (x <= 0 || y <= 0) {
                System.out.println("Chiều dài và chiều rộng phải là số nguyên dương!");
                return;
            }


            hcn rect = new hcn(x, y);


            System.out.println("Chu vi: " + rect.getPerimeter());
            System.out.println("Diện tích: " + rect.getArea());

        } catch (NumberFormatException e) {
            System.out.println("Tham số phải là số nguyên!");
        }
    }
}