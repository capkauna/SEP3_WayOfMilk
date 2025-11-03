using System.Text.Json;

public class HttpCowService : ICowService
{
    private readonly HttpClient _httpClient;

    public HttpCowService(HttpClient httpClient)
    {
        _httpClient = httpClient;
    }

    public async Task<CowDto> CreateCowAsync(CreateCowDto request)
    {
        var jsonContent = JsonSerializer.Serialize(request);
        var httpContent = new StringContent(jsonContent, System.Text.Encoding.UTF8, "application/json");

        var response = await _httpClient.PostAsync("api/cows", httpContent);
        response.EnsureSuccessStatusCode();
        var content = await response.Content.ReadAsStringAsync();
        return JsonSerializer.Deserialize<CowDto>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
    }

    public async Task<List<CowDto>> GetAllAsync()
    {
        var response = await _httpClient.GetAsync("api/cows");
        response.EnsureSuccessStatusCode();
        var content = await response.Content.ReadAsStringAsync();
        return JsonSerializer.Deserialize<List<CowDto>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
    }

    public async Task<CowDto> GetByIdAsync(long id)
    {
        var response = await _httpClient.GetAsync($"api/cows/{id}");
        response.EnsureSuccessStatusCode();
        var content = await response.Content.ReadAsStringAsync();
        return JsonSerializer.Deserialize<CowDto>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
    }
}