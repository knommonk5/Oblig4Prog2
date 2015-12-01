import java.util.*;

public class Data {

	private List<Entry> dupList;
	private Map<String, Entry> entry;
	private List<String> errors;
	private Reader reader;

	public Data(Reader reader) {
		dupList = new ArrayList<>();
		entry = new HashMap<>();
		errors = new ArrayList<>();
		this.reader = reader;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		if (reader == null)
			throw new IllegalArgumentException("We need some values, not null");
		this.reader = reader;
	}

	public String readLine() {
		String line = reader.readLine();
		if (line.length() != 58)
			throw new IllegalArgumentException("Line is too short");
		return line;
	}

	public void readFile() {
		String line;

		while ((line = readLine()) != null)
			save(line);
	}

	private String getResult(String line, String[] tokens) {
		String binaryResult = null;

		try {
			binaryResult = calculate(tokens[1], tokens[2], tokens[3]);
		} catch (IllegalArgumentException e) {
			saveError(line);
		}

		return binaryResult;
	}

	protected String calculate(String bitwise, String first, String second) {
		if (!bitwise.matches("[12]+"))
			throw new IllegalArgumentException("Faulty operators, Mason");

		if (bitwise.equals("1"))
			return Utility.bitwiseAnd(first, second);
		else
			return Utility.bitwiseOr(first, second);
	}

	protected void save(String line) {
		String[] tokens = splitLine(line);
		String binaryResult = getResult(line, tokens);

		if (entry.containsKey(tokens[0]))
			duplicates.add(newEntry(tokens, binaryResult));
		else if (binaryResult != null)
			saveNormal(tokens, binaryResult);
	}

	private void saveNormal(String[] tokens, String binaryResult) {
		entry.put(tokens[0], newEntry(tokens, binaryResult));
	}

	private Entry newEntry(String[] tokens, String binaryResult) {
		return new Entry(tokens[1], tokens[2], tokens[3], binaryResult, Utility.binToDecConv(binaryResult));
	}

	public List<Entry> getDuplex() {
		return dupList;
	}

	private void saveError(String l) {
		errors.add(l);
	}

	public List<String> getErrors() {
		return errors;
	}

	public Entry getEntry(String hexKey) {
		return entry.get(hexKey);
	}

	public List<Entry> getDuplicates() {
		return duplicates;
	}

}

class Entry {

	private Integer dec;
	private String bitwise, first, second, bin;

	public Entry(String bitwise, String first, String second, String bin, Integer dec) {
		this.bitwise = bitwise;
		this.first = first;
		this.second = second;
		this.bin = bin;
		this.dec = dec;
	}

	public String getBitwise() {
		return bitwise;
	}

	public String getFString() {
		return first;
	}

	public String getSString() {
		return second;
	}

	public String getBinResult() {
		return bin;
	}

	public Integer getDecResult() {
		return dec;
	}
}
