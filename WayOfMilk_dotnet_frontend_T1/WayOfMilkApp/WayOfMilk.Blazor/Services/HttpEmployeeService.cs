using System.Text.Json;

public class HttpEmployeeService : IEmployeeService
{
    private readonly HttpClient _httpClient;

    public HttpEmployeeService(HttpClient httpClient)
    {
        _httpClient = httpClient;
    }

    public async Task<List<EmployeeDto>> GetAllAsync()
    {
        var response = await _httpClient.GetAsync("api/employees");
        response.EnsureSuccessStatusCode();
        var content = await response.Content.ReadAsStringAsync();
        return JsonSerializer.Deserialize<List<EmployeeDto>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
    }

    public async Task<EmployeeDto> GetByIdAsync(long id)
    {
        var response = await _httpClient.GetAsync($"api/employees/{id}");
        response.EnsureSuccessStatusCode();
        var content = await response.Content.ReadAsStringAsync();
        return JsonSerializer.Deserialize<EmployeeDto>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
    }
}