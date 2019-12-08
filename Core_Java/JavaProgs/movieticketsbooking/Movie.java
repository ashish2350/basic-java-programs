package movieticketsbooking;

public class Movie
{
	
	private String name, actor, actress, music;
	
	public Movie(String name, String actor, String actress, String music)
	{
		this.name = name;
		this.actor = actor;
		this.actress = actress;
		this.music = music;
	}

	public String getName()
	{
		return this.name;
	}

	public String getActor()
	{
		return this.actor;
	}

	public String getActress()
	{
		return this.actress;
	}

	public String getMusic()
	{
		return this.music;
	}
}