public class P2 extends Thread
{
	private JobController ab;
	private JobController bc;
	private JobController bd;
	private JobController ce;
	private JobController de;
	private JobController ef;
	private JobController eg;

	public P2(JobController ab, JobController bc, JobController bd, JobController ce, JobController de, JobController ef, JobController eg)
	{
		this.ab = ab;
		this.bc = bc;
		this.bd = bd;
		this.ce = ce;
		this.de = de;
		this.ef = ef;
		this.eg = eg;
	}

	public void B()
	{
		System.out.println("B");
	}

	public void X()
	{
		System.out.println("X");
	}

	public void E()
	{
		System.out.println("E");
	}

	public void run()
	{
		ab.isJobDone();
		B();
		bd.jobDone();
		bc.jobDone();
		X();
		ce.isJobDone();
		de.isJobDone();
		E();
		ef.jobDone();
		eg.jobDone();
	}
}
