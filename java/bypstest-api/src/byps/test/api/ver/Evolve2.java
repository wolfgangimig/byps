package byps.test.api.ver;

import java.io.Serializable;

public class Evolve2 implements Serializable {
	private static final long serialVersionUID = 2831528882055697425L;
	int n1;
	public Evolve2() {
		
	}
	public Evolve2(int n1) {
		this.n1 = n1;
	}
  public int getN1() {
    return n1;
  }
  public void setN1(int n1) {
    this.n1 = n1;
  }
}
