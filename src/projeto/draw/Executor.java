package projeto.draw;

// Dicas:

// (1) Double.parseDouble(string) converte uma string num double

// (2) É possível usar a classe Scanner para retirar tokens de uma string
//
//   Scanner sc = new Scanner(string).useDelimiter("\\s* \\s*");
//   while (sc.hasNext()) {
//     String token = sc.next();
//     ... // process token
//   }
//   sc.close();

// (3) Estudem os métodos split() e trim() da API da classe String
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import projeto.strategies.Add;
import projeto.strategies.And;
import projeto.strategies.Circle;
import projeto.strategies.Cos;
import projeto.strategies.Division;
import projeto.strategies.Dup;
import projeto.strategies.Eos;
import projeto.strategies.Equals;
import projeto.strategies.FillOff;
import projeto.strategies.FillOn;
import projeto.strategies.Greater;
import projeto.strategies.Lesser;
import projeto.strategies.Line;
import projeto.strategies.Move;
import projeto.strategies.Nil;
import projeto.strategies.Not;
import projeto.strategies.Or;
import projeto.strategies.Point;
import projeto.strategies.Pop;
import projeto.strategies.Power;
import projeto.strategies.Product;
import projeto.strategies.Rectangle;
import projeto.strategies.Rgb;
import projeto.strategies.Rline;
import projeto.strategies.Rnd;
import projeto.strategies.Sin;
import projeto.strategies.Size;
import projeto.strategies.Square;
import projeto.strategies.Strategy;
import projeto.strategies.Swap;
import projeto.strategies.Window;

/**
 * Grupo numero: 020
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 */
public class Executor {

	/**
	 * The input stream
	 */
	private BufferedReader in; // input and ouput streams

	/**
	 * The output stream
	 */
	private BufferedWriter out;

	/**
	 * Initial state
	 */
	private State state = new State();

	/**
	 * A list to store the block of code for ifs and loops
	 */
	private List<String> params = new ArrayList<>();

	/**
	 * A list to store function arguments
	 */
	private ArrayList<double[]> paramsFunc = new ArrayList<>();

	/**
	 * A list for the various states
	 */
	private LinkedList<State> states = newStateList();

	/**
	 * Index for the current loop
	 */
	private int currentLoop;

	/**
	 * Index for the current state
	 */
	private int index;

	/**
	 * A map for pre-defined functions
	 */
	private Map<String, Strategy> map = initializeMap();

	/**
	 * A map for functions defined in the script
	 */
	private Map<String, Macro> macroMap = new HashMap<>();

	/**
	 * Line separator
	 */
	public static final String EOL = System.getProperty("line.separator");

	// Print values using this format
	// use eg: df.format(value).replace(",", "."))
	private static DecimalFormat df = new DecimalFormat("#.###");

	/**
	 * The Executor constructor builds a new object of the Executor class
	 * 
	 * @param in  - the input stream
	 * @param out - the output stream
	 */
	public Executor(BufferedReader in, BufferedWriter out) {
		this.in = in;
		this.out = out;
	}

	/**
	 * Process a line. It can be: <br>
	 * * a comment: starts with '#' <br>
	 * * a function definition: "[name:arity] expression" <br>
	 * * an expression (produces an effect on the stack)
	 * 
	 * @param line A text line with code
	 * @requires A syntatical valid line of code
	 * @ensures A function definition adds to the function data structure
	 * @ensures An expression is evaluated and its effects modify the stack
	 */
	public void processLine(String line) {
		Scanner sc = new Scanner(line).useDelimiter(" (?=[^\\]]*(?:\\[|$))");
		Stack<String> paren = new Stack<String>();

		do {
			String current = "";
			try {
				current = sc.next();
			} catch (Exception e) {
				current = "#";
			}
			switch (current) {
			case "":
				break;
			case "#":
				return;
			case "{":
				paren.push(current);
				StringBuilder sb = new StringBuilder();
				sb.append(paren.peek() + " ");
				while (!paren.isEmpty()) {
					String top = sc.next();
					switch (top) {
					case "{":
						paren.push(top);
						sb.append(paren.peek() + " ");
						break;
					case "}":
						sb.append(top + " ");
						paren.pop();
						break;
					default:
						sb.append(top + " ");
					}
				}
				params.add(sb.toString().substring(2, sb.toString().length() - 3));
				break;
			case "loop":
				loop();
				break;
			case "if":
				ifBlock();
				break;
			case "next":
				Next();
				break;
			case "prev":
				Previous();
				break;
			case "?":
				processLine(readInputStream());
				break;
			case ".":
				printLine();
				break;
			case ",":
				print();
				break;
			default:
				char currentStart = current.charAt(0);
				switch (currentStart) {
				case '[':
					StringBuilder s = new StringBuilder();
					s.append(current);
					while (sc.hasNext()) {
						s.append(sc.next() + " ");
					}
					newMacro(s.toString());
					break;
				case '@':
					newVariable(current);
					break;
				case '$':
					if (current.charAt(1) == '$') {
						for (double i : paramsFunc.get(paramsFunc.size() - 1))
							state.push(i);
					} else {
						int paramNum = Integer.parseInt(current.substring(1));
						state.push(paramsFunc.get(paramsFunc.size() - 1)[paramNum - 1]);
					}
					break;
				default:
					if (isNumeric(current)) {
						state.push(Double.parseDouble(current));
					} else if (map.containsKey(current)) {
						map.get(current).execute(state);
					} else if (macroMap.containsKey(current)) {
						int arity = macroMap.get(current).getArity();
						paramsFunc.add(new double[arity]);
						for (int i = arity; i > 0; i--)
							paramsFunc.get(paramsFunc.size() - 1)[i - 1] = state.pop();
						processLine(macroMap.get(current).getDescription());
						paramsFunc.remove(paramsFunc.size() - 1);
					}
				}
			}
		} while (sc.hasNext());
		sc.close();
	}

	/**
	 * Initializes the Strategy map with all the pre defined functions
	 * 
	 * @return a new Strategy map
	 */
	private HashMap<String, Strategy> initializeMap() {
		HashMap<String, Strategy> newMap = new HashMap<>();
		newMap.put("+", new Add());
		newMap.put("&", new And());
		newMap.put("circle", new Circle());
		newMap.put("cos", new Cos());
		newMap.put("/", new Division());
		newMap.put("dup", new Dup());
		newMap.put("eos", new Eos());
		newMap.put("=", new Equals());
		newMap.put("fill-off", new FillOff());
		newMap.put("fill-on", new FillOn());
		newMap.put("line", new Line());
		newMap.put("move", new Move());
		newMap.put("nil", new Nil());
		newMap.put("!", new Not());
		newMap.put("|", new Or());
		newMap.put("point", new Point());
		newMap.put("pop", new Pop());
		newMap.put("rectangle", new Rectangle());
		newMap.put("rgb", new Rgb());
		newMap.put("rline", new Rline());
		newMap.put("size", new Size());
		newMap.put("square", new Square());
		newMap.put("swap", new Swap());
		newMap.put("window", new Window());
		newMap.put("*", new Product());
		newMap.put("^", new Power());
		newMap.put("<", new Lesser());
		newMap.put(">", new Greater());
		newMap.put("rnd", new Rnd());
		newMap.put("sin", new Sin());

		return newMap;
	}

	/**
	 * Initializes the state list with the initial state
	 * 
	 * @return The state list
	 */
	private LinkedList<State> newStateList() {
		LinkedList<State> newStateList = new LinkedList<>();
		newStateList.add(state);
		return newStateList;
	}

	/**
	 * Processes the current loop
	 */
	private void loop() {
		currentLoop++;
		double bound = state.pop();
		for (double i = 1; i <= bound; i++) {
			state.push(i);
			processLine(params.get(currentLoop - 1));
		}
		currentLoop--;

		params.remove(params.size() - 1);
	}

	/**
	 * Processes if statements
	 */
	private void ifBlock() {
		if (state.peek() == 1.0) {
			state.pop();
			processLine(params.get(params.size() - 2));
		} else {
			state.pop();
			processLine(params.get(params.size() - 1));
		}
	}

	/**
	 * Creates a new macro function
	 */
	private void newMacro(String s) {
		String macroName = s.substring(1, s.indexOf(":")).trim();
		int arity = Integer.parseInt(s.substring(s.indexOf(":") + 1, s.indexOf("]")).trim());
		String description = s.substring(s.indexOf("]") + 1).trim();
		macroMap.put(macroName, new Macro(macroName, arity, description));
	}

	/**
	 * Creates a new variable as a macro
	 */
	private void newVariable(String s) {
		String varName = s;
		StringBuilder sb = new StringBuilder(varName);
		sb.deleteCharAt(0);
		Macro variable = new Macro(sb.toString(), 0, state.pop().toString());
		macroMap.put(sb.toString(), variable);
	}

	/**
	 * Determines if a given String is a number
	 * 
	 * @param str - The String to be checked
	 * @return true if the String is numeric, false if otherwise
	 */
	private boolean isNumeric(String str) {
		boolean result = true;
		if (str == null) {
			result = false;
		} else {
			try {
				Double.parseDouble(str);
			} catch (NumberFormatException nfe) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Changes the current stack to the next one. If no such stack exists, a new one
	 * is created
	 */
	private void Next() {
		index++;
		ListIterator<State> itr = states.listIterator(index);
		if (itr.hasNext())
			state = itr.next();
		else {
			state = new State();
			states.addLast(state);
		}
	}

	/**
	 * Changes the current stack to the previous one. If no such stack exists, a new
	 * one is created
	 */
	private void Previous() {
		ListIterator<State> itr = states.listIterator(index);
		index--;
		if (itr.hasPrevious())
			state = itr.previous();
		else {
			state = new State();
			states.addFirst(state);
		}
	}

	/**
	 * Reads from the input stream
	 */
	private String readInputStream() {
		String line = "";
		try {
			line = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

	/**
	 * Prints the top of the state onto the output stream with a line separator at
	 * the end
	 */
	private void printLine() {
		try {
			out.write(df.format(state.pop()).replace(",", ".") + EOL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the top of the state onto the output stream
	 */
	private void print() {
		try {
			out.write(df.format(state.pop()).replace(",", ".") + " ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}