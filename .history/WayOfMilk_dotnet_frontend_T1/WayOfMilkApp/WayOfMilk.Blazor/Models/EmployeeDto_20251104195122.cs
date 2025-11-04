namespace WayOfMilk.BlazorApp.Models;

public class EmployeeDto
{
    public required string Name { get; set; }
    public required string Email { get; set; }
    public required string Address { get; set; }
    public required string Phone { get; set; }
    public long Id { get; set; }
}
