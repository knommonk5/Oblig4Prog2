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
	private String fString = "101010101010101010101010";
	private String sString = "000000011111111000000011";

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
		assertEquals("123abc 1" + fString + " " + sString);
	}

	@Test(expected = IllegalArgumentException.class)
    public void readLine_faultyLine_returnException() {
        when(mockReader.readLine()).thenReturn("123abb 1 " + fString);
        data.readLine();
    }
}
