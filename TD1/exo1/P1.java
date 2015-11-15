public class P1 extends Thread
{
	private JobController ab;
	private JobController ef;
	private JobController bd;
	private JobController de;

	public P1(JobController ab, JobController bd, JobController de, JobController ef)
	{
		this.ab = ab;
		this.bd = bd;
		this.de = de;
		this.ef = ef;
	}

	public void A()
	{
		System.out.println("A");
	}

	public void D()
	{
		System.out.println("D");
	}

	public void F()
	{
		System.out.println("F");
	}

	public void run()
	{
		A();
		ab.jobDone();
		bd.isJobDone();
		D();
		de.jobDone();
		ef.isJobDone();
		F();
	}
}
