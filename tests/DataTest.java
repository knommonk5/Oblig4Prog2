import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Before;
import org.junit.Test;

public class DataTest {
	private Data data;
	private Reader mockReader;
	private String fString = "110101000000110111001101";
	private String sString = "001000011110011101001111";
	private String AND = "000000000000010101001101";
	private String OR = "111101011110111111001111";

	@Before
	public void setUp() throws Exception {
		mockReader = mock(Reader.class);
		data = new Data(mockReader);
	}

	@Test
	public void checkReader_shouldReturnMockReader() {
		assertEquals(mockReader, data.getReader());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setReader_Null_ReturnException() {
		data.setReader(null);
	}

	@Test
	public void readLine_correctValues_returnLegitLine() {
		when(mockReader.readLine()).thenReturn("thisTest 1 " + fString + " " + sString);
		equals("123abc 1" + fString + " " + sString);// TODO
	}

	@Test(expected = IllegalArgumentException.class)
	public void readLine_faultyLine_returnException() {
		when(mockReader.readLine()).thenReturn("123abb 1 " + fString);
		data.readLine();
	}

	@Test
	public void splitLine_regularInput_returnSplitLine() {
		String[] parts = data.splitLine("abc123 1 " + fString + " " + sString);
		assertEquals("abc123", parts[0]);
		assertEquals("1", parts[1]);
		assertEquals(fString, parts[2]);
		assertEquals(sString, parts[3]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void readLine_notCompleteLine_expectedException() {
		when(mockReader.readLine()).thenReturn("123abc 1 " + fString);
		data.readLine();
	}

	@Test(expected = IllegalArgumentException.class)
	public void calculate_badOperatir_exception() {
		data.calculate("3", fString, sString);
	}

	@Test
	public void calculate_BWAndAndReturns_Correctly() {
		assertEquals(AND, "1" + fString + " " + sString);
	}

	@Test
	public void calculate_BWOrAndReturns_Correctly() {
		assertEquals(OR, "2" + fString + " " + sString);
	}

	@Test
	public void saveResults_normalInput_saveValues() {
		data.saveResults("123abc 1 " + fString + " " + sString);
		assertEquals("1", data.getEntry("123aabc").getOperator());
		assertEquals(fString, data.getEntry("123aabc").getFString());
		assertEquals(sString, data.getEntry("123aabc").getSString());
		assertEquals(AND, data.getEntry("123aabc").getBinResult());
		assertEquals(, data.getEntry("123aabc").getDecimalResult());
	}

	@Test
	public void saveResults_duplicatedKey_shouldSaveInLog() {
		data.saveResults("123abc 1 " + fString + " " + sString);
		data.saveResults("123abc 2 " + sString + " " + fString);
		assertEquals("2",data.getDuplicates().get( 0 ).getOperator());
		assertEquals(sString,data.getDuplicates().get( 0 ).getFirstString());
		assertEquals(fString,data.getDuplicates().get( 0 ).getSecondString());
		assertEquals(OR,data.getDuplicates().get( 0 ).getBinaryResult());
		assertEquals(,data.getDuplicates().get( 0 ).getDecimalResult());
		
	}
}
