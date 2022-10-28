package projeto.start;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import projeto.draw.Executor;

public class Start {

	public static void main(String[] args) throws Exception {

		// BufferedReader data = new BufferedReader( new FileReader("data/data.txt") );
		BufferedReader data = new BufferedReader(new InputStreamReader(System.in));

		// BufferedWriter output = new BufferedWriter( new FileWriter("result.txt") );
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		BufferedReader program = new BufferedReader(new FileReader("data/draw-koch-circle.txt"));

		Executor ex = new Executor(data, output);

		String line;
		while ((line = program.readLine()) != null)
			ex.processLine(line);

		data.close();
		output.close();
		program.close();
	}
}
