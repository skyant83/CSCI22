public class CalledProgram {
    private int totalAdded = 0;

	public int Addition(int x, int y){
		int sum = x + y;
		totalAdded += sum;
		return sum;
	}

	public void displayTotalSum() {
		System.out.println(totalAdded);
	}
}
