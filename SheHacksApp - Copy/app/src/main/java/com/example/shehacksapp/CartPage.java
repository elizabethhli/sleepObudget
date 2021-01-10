package com.example.shehacksapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartPage extends AppCompatActivity {

    ArrayList<String> name, price, amount;
    DatabaseHelper db;
    CustomAdapter customAdapter;
    ListView items_list;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);

        if (LoginPage.getEmail() == null || LoginPage.getEmail().equals("")) {
            email = SignUpPage.getEmail();
        } else {
            email = LoginPage.getEmail();
        }

        items_list = findViewById(R.id.items_list);
        name = new ArrayList<>();
        price = new ArrayList<>();
        amount = new ArrayList<>();

        final Cursor cursor = db.getName(email);
        while (cursor.moveToNext()) {
            int i = cursor.getColumnIndexOrThrow("name");
            name.add(cursor.getString(i));
        }

        final Cursor cursor2 = db.getPrice(email);
        while (cursor.moveToNext()) {
            int i = cursor.getColumnIndexOrThrow("price");
            price.add(cursor.getString(i));
        }

        final Cursor cursor3 = db.getAmount(email);
        while (cursor.moveToNext()) {
            int i = cursor.getColumnIndexOrThrow("amount");
            amount.add(cursor.getString(i));
        }

        customAdapter = new CustomAdapter(name, price,CartPage.this);
        items_list.setAdapter(customAdapter);

        //code for the total price
        double spent = CandyPage.getPrice() + ChipsPage.getPrice() + DinnerPage.getPrice() + DrinksPage.getPrice()
                + EntertainmentPage.getPrice() + iceCreamPage.getPrice() + VenuePage.getPrice();
​
        int budget = (25*BudgetPage.getNumPeople() + 50);
        if (spent > budget) {
            System.out.println("Wow, you surpassed your budget by " + (int)(spent - budget)
                    + "! Next time, try to think about the opportunity cost of your purchases."
                    + "Opportunity cost is the cost of what you give up in choosing to buy your top choice!"
                    + "For example, choosing to host your sleepover party at an Airbnb would cost you $210!"
                    + "That only leaves you with $10 to buy food, drinks, and entertainment. Is it worth it?"
                    + "Well, this varies from person to person. One person may find it totally worth it, "
                    + "but another person may find it crazy how someone is willing to spend 95% of their budget on only the venue! "
                    + "This is the idea of opportunity cost! Next time you make a purchase with your hard-earned money, "
                    + "take some time to think about if the trade-off is worth it!");
        }
        else if (spent == budget) {
            System.out.println("That was a close one! You spent your budget exactly! In the future, don't be afraid to "
                    + "save a little extra next time. That way, you can choose to save the amount leftover, invest it to try and grow your money, "
                    + "use it towards your next purchase, or however else you like! ");
        }
        else if (spent < (budget - 100)) {
            System.out.println("Great job! You saved " + (int)(spent - budget)
                    + "! Now you can use this extra money you saved to spend, invest, or save. It's up to you! "
                    + "Keep up the great work! Now let's learn about why you were able to save so much: "
                    + "Opportunity cost is the cost of what you give up in choosing to buy your top choice!"
                    + "For example, choosing to host your sleepover party at an Airbnb would cost you $210!"
                    + "That only leaves you with $10 to buy food, drinks, and entertainment. Is it worth it?"
                    + "Based off of this game, you have shown that you are willing to make the decisions"
                    + " that result in a lower opportunity cost. This means, you were willing to choose "
                    + "products that made you give up less value. "
                    + "The amount people value different products varies from person to person. Back to the example, "
                    + "one person may find it totally worth it, but another person may find it crazy how someone is "
                    + "willing to spend 95% of their budget on only the venue! "
                    + "This is the idea of opportunity cost! Next time you make a purchase with your hard-earned money, "
                    + "take some time to think about if the trade-off is worth it!");
        }

    }
}