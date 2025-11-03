public interface ICowService
{
    public Task<CowDto> CreateCowAsync(CreateCowDto request);
    public Task<List<CowDto>> GetAllAsync();
    public Task<CowDto> GetByIdAsync(long id);
}