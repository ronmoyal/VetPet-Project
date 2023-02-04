package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FAQUser extends AppCompatActivity implements View.OnClickListener {
    Button btnDogEat;
    Button btnDogBurn;
    Button btnDogBit;
    Button btnDogTreatments;
    Button btnDogNeutering;
    Button btnDogTrain;
    Button btnCatVaccine;
    Button btnCatWash;
    Button btnCatMarch;
    Button btnCatEat;
    Button btnCatMilk;
    Button btnCatPoop;
//    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faquser);

        btnDogEat = (Button)findViewById(R.id.btnDogEat);
        btnDogBurn = (Button)findViewById(R.id.btnDogBurn);
        btnDogBit = (Button)findViewById(R.id.btnDogBit);
        btnDogTreatments = (Button)findViewById(R.id.btnDogTreatments);
        btnDogNeutering = (Button)findViewById(R.id.btnDogNeutering);
        btnDogTrain = (Button)findViewById(R.id.btnDogTrain);
        btnCatVaccine = (Button)findViewById(R.id.btnCatVaccine);
        btnCatWash = (Button)findViewById(R.id.btnCatWash);
        btnCatMarch = (Button)findViewById(R.id.btnCatMarch);
        btnCatEat = (Button)findViewById(R.id.btnCatEat);
        btnCatMilk = (Button)findViewById(R.id.btnCatMilk);
        btnCatPoop = (Button)findViewById(R.id.btnCatPoop);

        btnDogEat.setOnClickListener(this);
        btnDogBurn.setOnClickListener(this);
        btnDogBit.setOnClickListener(this);
        btnDogTreatments.setOnClickListener(this);
        btnDogNeutering.setOnClickListener(this);
        btnDogTrain.setOnClickListener(this);
        btnCatVaccine.setOnClickListener(this);
        btnCatWash.setOnClickListener(this);
        btnCatMarch.setOnClickListener(this);
        btnCatEat.setOnClickListener(this);
        btnCatMilk.setOnClickListener(this);
        btnCatPoop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDogEat:
                Toast.makeText(this, "כל כלב הוא עולם ומלאו!\n" +
                        "חשוב לאבחן אם יש סיבה רגשית לעובדה שהוא לא אוכל.\n" +
                        "אם זה כלב חדש שהגיע הביתה אז אולי הוא עדיין בסטרס ומנסה להתאקלם אולי יש לו מצב רוח ירוד בגלל איזשהו שינוי בבית, בשגרה וכו'... \n" +
                        "מומלץ להיעזר באיש מקצוע!\n", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDogBurn:
                Toast.makeText(this, "כטיפול ראשוני (אפילו בשטח) כדאי לחבוש את הרגל ולמנוע זיהום של המקום.\n" +
                        "לאחר מכן כדאי להגיע לווטרינר שיבדוק את הכלב, ייתכן טיפול מתאים (אנטיביוטיקה לפי הצורך) ושיכוך כאבים.\n" +
                        "במקרה הצורך יבוצעו חבישות ותימרח משחה על הכוויות.\n" +
                        "\uFEFF", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDogBit:
                Toast.makeText(this, " כשכלב נושך הוא אוטומטית הופך להיות חשוד כחולה במחלת הכלבת.\n" +
                        "כדי להגן על בריאות הציבור, יש לבודד אותו מאנשים ובעלי חיים אחרים ובאופן זה למנוע ממנו להפיץ את המחלה. \n" +
                        "נאלץ להכניס את הכלב להסגר ביתי או עירוני על פי החלטת הויטרינר \n", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDogTreatments:
                Toast.makeText(this, "חיסון משושה, חיסון כלבת חיסון תולעת הפארק וטיפול נגד קרציות" , Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDogNeutering:
                Toast.makeText(this, "הדעה הוטרינרית הרווחת היא כי סירוס הוא אמצעי יעיל ונכון לשליטה על אוכלוסיית הכלבים ולשיפור חייהם וחיי הסובבים אותם.\n" +
                        "\n לדעה זו חסרונות ויתרונות רבים ולכן חשוב להיוועץ עם הגורצמים הרלוונטים " , Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDogTrain:
                Toast.makeText(this, "הכלב יהיה יותר ממושמע וצייתן, לא יתפתחו בעיות התנהגות, הוא יבין את מיקומו בהיררכיה, ויפתח שפה משותפת עם הבעלים.\n" +
                        "האילוף ישפר את התקשורת בין הבעלים לכלב!\n" , Toast.LENGTH_LONG).show();
            case R.id.btnCatVaccine:
                Toast.makeText(this, "כל החתולים זקוקים לחיסונים ולטיפולי מניעה!\n" +
                        "חיסון מרובע לחתולים יכלול: חתלתלת, רינוטרכיאיטיס, קליצי וכלמידיה\n" , Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCatWash:
                Toast.makeText(this, " אין כל צורך ואפילו אסור לרחוץ חתולים!\n" +
                        "מקלחת מותרת רק במקרה דחוף ובהמלצת וטרינר, אנא בלי מקלחות בבקשה - חתולים מחטאים עצמם כל הזמן" , Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCatMarch:
                Toast.makeText(this, "מחלת שריטת החתול היא מחלה זיהומית הנגרמת על ידי חיידק בשם ברטונלה\n" +
                        "החיידק מועבר לבני האדם דרך הרוק שריטה או נשיכה של החתולֿ\n" +
                        "המחלה אינה מלווה לרוב בתסמינים חריפים או השלכות בריאותיות קשות.", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCatEat:
                Toast.makeText(this, "כמות המזון שחתול צורך מדי יום תלויה במספר גורמים:\n" +
                        "המשקל של החתול, רמת הפעילות של החתול וכמות הקלוריות שיש במזון.\n" +
                        "רוב החתולים יודעים לווסת לעצמם את הכמות הדרושה וניתן פשוט לדאוג שבקערה שלהם יהיה כל הזמן מזון.\n" , Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCatMilk:
                Toast.makeText(this, "לגורים מומלץ להציע אך ורק חלב אם בשבועות הראשונים לחייהם.\n " +
                        "במידה והחתול הופרד מאמו ולא יכול לינוק, יש לתת לו אבקת חלב לחתולים, המיועדת לחתולים מגיל לידה ועד גיל 35 יום.\n" , Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCatPoop:
                Toast.makeText(this, "יש הרבה סיבות שעלולות לגרום לחתול שלכם לא לאהוב את ארגז הצרכים \n" +
                        "כגון: ריח לא נעים, תדירות ניקוי נמוכה, חול מסוג חדש, גודל קטן מדי של הארגז או מיקום לא נכון בבית." , Toast.LENGTH_LONG).show();
                break;
        }
    }
}



