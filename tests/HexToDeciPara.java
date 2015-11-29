import static org.junit.Assert.assertEquals;

@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class HexToDeciPara {
	private String hex;
	private int deci;

	public HexToDeciPara(String hex, String deci) {
		this.hex = hex;
		this.deci = Integer.parseInt(deci);
	}

	@org.junit.runners.Parameterized.Parameters
	public static java.util.Collection<String[]> input() {
		return java.util.Arrays.asList(new String[][] { { "BC614E", "12345678" }, { "01E240", "123456" },
				{ "0004D2", "1234" }, { "000021", "33" } });
	}

	@org.junit.Test
	public void testHexToDeciConversion() {
		assertEquals((deci), Utility.hexToDeciConv(hex));
	}
}