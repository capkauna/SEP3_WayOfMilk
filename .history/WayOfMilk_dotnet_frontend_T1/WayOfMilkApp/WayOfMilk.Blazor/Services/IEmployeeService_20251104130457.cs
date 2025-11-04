namespace BlazorApp.Services;

public interface IEmployeeService
{
    public Task<List<EmployeeDto>> GetAllAsync();
    public Task<EmployeeDto> GetByIdAsync(long id);
}