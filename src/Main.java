public class Main {
    public static void main(String[] args) {
        //Product snusEttanLös = new Product("Ettan lös", 69, 1102);
        Product mjölk = new Product("Mjölk", 28, 47);
        Product bröd = new Product("Bröd", 33, 12);

        Discount discountChain = new FridayDiscount(
                new MilkDiscount(
                        new QuantityDiscount(null)));

        //System.out.println(snusEttanLös.toString());

        double milkDiscount = discountChain.apply(mjölk);
        String milkDescription = discountChain.getDescription(mjölk);
        System.out.println("Mjölk slutpris: " + (mjölk.price() - milkDiscount));
        System.out.println("Rabatter: " + milkDescription);

        double breadDiscount = discountChain.apply(bröd);
        String breadDescription = discountChain.getDescription(bröd);
        System.out.println("Bröd slutpris: " + (bröd.price() - breadDiscount));
        System.out.println("Rabatter: " + breadDescription);
    }
}
