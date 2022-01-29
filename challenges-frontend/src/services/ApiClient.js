class ApiClient {
    static SERVER_URL='http://localhost:8000';
    static GET_CHALLENGE = '/challenges/random';
    static POST_RESULTS = '/attempts';
    static GET_ATTEMPTS_BY_ALIAS = '/attempts?alias=';

    static challenge(): Promise<Response> {
        return fetch(ApiClient.SERVER_URL + ApiClient.GET_CHALLENGE);
    }

    static sendGuess(user: string,
                     a: number,
                     b: number,
                     guess: number): Promise<Response> {
        return fetch(ApiClient.SERVER_URL+ApiClient.POST_RESULTS,
            {
                method: 'POST',
                headers: {
                    'Content-Type':'application/json'
                },
                body: JSON.stringify(
                    {
                        userAlias: user,
                        factorA: a,
                        factorB: b,
                        guess: guess
                    }
                )
            });
    }

    static getAttempts(userAlias: string): Promise<Response> {
        console.log('Get attempts for '+userAlias);
        return fetch(ApiClient.SERVER_URL + ApiClient.GET_ATTEMPTS_BY_ALIAS + userAlias);
    }
}

export default ApiClient;