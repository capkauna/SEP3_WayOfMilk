namespace WayOfMilk.BlazorApp.Models;

public class CowDto
{
    public long Id { get; set; }
    public required string RegNo { get; set; }
    public required DateTime BirthDate { get; set; }
    public required Boolean IsHealthy { get; set; }
}