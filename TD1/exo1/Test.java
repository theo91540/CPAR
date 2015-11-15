public class Test
{
	public static void main(String[] args)
	{
		JobController ab = new JobController();
		JobController bd = new JobController();
		JobController bc = new JobController();
		JobController de = new JobController();
		JobController ce = new JobController();
		JobController ef = new JobController();
		JobController eg = new JobController();

		P1 p1 = new P1(ab, bd, de, ef);
		P2 p2 = new P2(ab, bc, bd, ce, de, ef, eg);
		P3 p3 = new P3(bc, ce, eg);

		p1.start();
		p2.start();
		p3.start();
	}
}