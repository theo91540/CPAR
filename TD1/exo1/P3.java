public class P3 extends Thread
{
	private JobController bc;
	private JobController ce;
	private JobController eg;

	public P3(JobController bc, JobController ce, JobController eg)
	{
		this.bc = bc;
		this.ce = ce;
		this.eg = eg;
	}

	public void C()
	{
		System.out.println("C");
	}

	public void G()
	{
		System.out.println("G");
	}

	public void run()
	{
		bc.isJobDone();
		C();
		ce.jobDone();
		eg.isJobDone();
		G();
	}
}
