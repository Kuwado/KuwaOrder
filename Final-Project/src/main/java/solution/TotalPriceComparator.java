package solution;

import model.tabledata.MOChosenQuantity;
import java.util.Comparator;

public class TotalPriceComparator implements Comparator<MOChosenQuantity> {
    private double number;

    public TotalPriceComparator(double number) {
        this.number = number;
    }

    @Override
    public int compare(MOChosenQuantity cq1, MOChosenQuantity cq2) {
        double totalPrice1 = cq1.getProductPrice() + cq1.getDeliveryPrice()/number ;
        double totalPrice2 = cq2.getProductPrice() + cq2.getDeliveryPrice()/number ;
        return Double.compare(totalPrice1, totalPrice2);
    }
}

