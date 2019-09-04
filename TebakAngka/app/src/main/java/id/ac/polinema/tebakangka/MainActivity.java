package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	int angkaMesin;
	int angkaInput;
	private EditText numberInput;
	private Button submitButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// TODO: bind layout di sini
		numberInput = findViewById(R.id.number_input);
		submitButton = findViewById(R.id.guess_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random rand = new Random();
		angkaMesin = rand.nextInt(100)+1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		angkaInput = Integer.parseInt(numberInput.getText().toString());

		if(angkaMesin < angkaInput){
			/* TODO: Jika angka mesin lebih kecil dari angka input
			 * AngkaMesin merupakan angka random
			 * Sedangkan angkaInput merupakan angka dari user
			 */
			Toast.makeText(this, "Tebakan anda terlalu besar! " + angkaMesin + " " + angkaInput, Toast.LENGTH_SHORT).show();
		}else if(angkaMesin > angkaInput){
			/* TODO: Jika angka mesin lebih besar dari angka input
			 * AngkaMesin merupakan angka random
			 * Sedangkan angkaInput merupakan angka dari user
			 */
			Toast.makeText(this, "Tebakan anda terlalu kecil! " + angkaMesin + " " + angkaInput, Toast.LENGTH_SHORT).show();
		}else{
			/* TODO: Jika angka mesin lebih besar dari angka input
			 * AngkaMesin merupakan angka random
			 * Sedangkan angkaInput merupakan angka dari user
			 */
			Toast.makeText(this, "Tebakan anda benar! " + angkaMesin + " " +angkaInput, Toast.LENGTH_SHORT).show();
			//	Disable Guess Button
			submitButton.setEnabled(false);
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		//	Acak angka
		initRandomNumber();
		//	Enable Guess Button
		submitButton.setEnabled(true);
		//	Menghapus teks pada numberInput
		numberInput.setText("");
	}
}
