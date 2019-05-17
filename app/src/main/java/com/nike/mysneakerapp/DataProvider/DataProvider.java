package com.nike.mysneakerapp.DataProvider;

import com.nike.mysneakerapp.R;
import com.nike.mysneakerapp.models.Brand;
import com.nike.mysneakerapp.models.Shoe;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<Brand> brandList;

    static {
        brandList = new ArrayList<>();

        //Add brands with their shoes
        Brand nike = new Brand("Nike", "25-1-1964", "Checks over stripes, that's what i like!", R.drawable.nike_logo);
        nike.addShoe(new Shoe("Nike Air Max 90 x Off-White", "7-2-2019", "Details", R.drawable.am90_ow));
        nike.addShoe(new Shoe("Nike Air Force 1 x Off-White", "19-12-2018", "Big drip fo sho !", R.drawable.af1_ow));
        nike.addShoe(new Shoe("Nike Air Max 1 x Parra", "21-7-2018", "Piet Parra made dis", R.drawable.am1_parra));
        nike.addShoe(new Shoe("Nike Air Max 1/97 x Sean Wotherspoon", "26-3-2018", "AirMax 1 bottom, AirMax 97 top. Designed by Sean Wotherspoon", R.drawable.am1_seanwotherspoon));
        nike.addShoe(new Shoe("Nike Air Jordan 1 x Travis Scott", "11-02-2019", "This reversed swoosh shock dropped during the 2019 Grammys, but will see a wider release on the 26th of April. ", R.drawable.aj1_travisscott));

        Brand adidas = new Brand("Adidas", "18-8-1949", "Ye", R.drawable.adidas_logo);
        adidas.addShoe(new Shoe("Adidas Yeezy 350 v1", "29-10-2015", "The OG's. Released in four colorways: Peyote, Moonrock, Chocolate and Pirate Black", R.drawable.yeezy350_v1));
        adidas.addShoe(new Shoe("Adidas Yeezy 350 v2", "24-9-2016", "A remake of the v1's. Released in several colorways", R.drawable.yeezy350_v2));
        adidas.addShoe(new Shoe("Adidas Yeezy 700 Waverunner", "12-8-2017", "Drip so hard, you call it a wave! First released in 2017, but was restocked a year later on the 15th of september", R.drawable.yeezy700_waverunner));
        adidas.addShoe(new Shoe("Adidas x Dragon Ball Z - 'Goku' & 'Frieza'", "29-9-2018", "Adidas Originals officially embarks upon its collaborative journey with legendary anime series Dragon Ball Z. Releasing throughout this holiday season, the adidas Dragon Ball Z collection will include seven releases in total – two per month representing a key rivalry leading up to one final drop in December. To start things off, adidas has tapped Goku and Frieza to represent the newly updated ZX 500 RM and the Yung-1, with each pair adorning colors, materials, and details corresponding to each character. Each pair of shoes will come packaged in a special edition adidas Dragon Ball Z shoebox that, when stacked together, reveal one larger image.", R.drawable.adidas_dragonballz));

        Brand vans = new Brand("Vans", "1966", "An American manufacturer of shoes aimed at skaters", R.drawable.vans_logo);
        vans.addShoe(new Shoe("Vans Old Skool", "1977", "Debuted in 1977 as the 'Style 36', the Old Skool was the first Vans shoe to incorporate leather panels, and one of the first to feature the now-iconic 'jazz stripe.'", R.drawable.vans_oldskool));
        vans.addShoe(new Shoe("Vans Old Skool High Tops", "1967", "For this shoe, Vans kept the two features of the Old Skool that skaters loved: the brand’s signature waffle sole and its canvas-leather construction. The original Style 38 came in navy blue leather with light blue canvas, cinnamon-hued rust leather on rust canvas, and brown leather on beige canvas. But customization was huge for Vans in its early days — shoes were even sold individually instead of in pairs, so you could mix and match colors. This was especially useful for skaters, since they tend to wear out one shoe before the other.", R.drawable.vans_oldskool_high));
        vans.addShoe(new Shoe("Vans x Supreme High Tops", "1-3-2018", "Included in the footwear portion of the collection are the Vans Sk8-Hi and the Vans Slip-On. Each pair features a black and glow-in-the-dark Liquid Blue Skull Pile pattern that was made popular by rapper Juicy J back in 2009. Both pairs are then finished off with white rubber midsole and the signature red Vans license plate on the heel.", R.drawable.vans_oldskool_high_supreme));

        addBrand(adidas);
        addBrand(nike);
        addBrand(vans);

    }

    public static void addBrand(Brand brand) {
        brandList.add(brand);
    }

    public static void deleteBrand(Brand brand) {
        brandList.remove(brand);
    }

    public static Brand getBrandByID(int id) {
        for (int i = 0; i < brandList.size(); i++) {
            if (id == brandList.get(i).getBrandID()) {
                return brandList.get(i);
            }
        }
        return null;
    }

    public static Shoe getShoeByID(int id) {
        for (Brand brand : brandList) {
            for (Shoe shoe : brand.getShoeList()) {
                if (shoe.getShoeID() == id) {
                    return shoe;
                }
            }
        }

        return null;
    }


}
