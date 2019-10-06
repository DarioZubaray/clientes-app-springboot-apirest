package com.github.dariozubaray.springboot.api.rest.auth;

public class JwtConfig {

    public static final String LLAVE_SECRETA = "alguna.clave.secreta.123456789";

    public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
            "MIIEowIBAAKCAQEAz4/NIWb6spcGZQc23MPLvWIo1NwDtAO/pLKptuPk5KDxRiSl\r\n" + 
            "IWDXpld3f8K2kjGc1B6X8dLTfNmhEI53mtq95594QlJIQZx93zyZIPamA5t7WzlR\r\n" + 
            "aDg/Wdd7v8z98kERBuHFtFyTv0EWfs+3NSjmjoqJBx+X67vRUbdwfiX5t5ttXXbK\r\n" + 
            "6DTAUe/LGrfN+1l94+rKmN5vBZ6118NmGGno1vZfd1YCCs1CfDWk9pwoEBzYqw14\r\n" + 
            "6H6LGjOXELZTNIOVfidVXpReZ5VVRa5kWWMn92OUC7mkprP2PavUjaf007q/Q4LY\r\n" + 
            "MIcPIA25mN37o6RNdHsiqVthc3PJxtfOA5BirwIDAQABAoIBADEZdE31fVJn1XRq\r\n" + 
            "q3i3vGd1Y/FOhnW7+UatmOYRrODEja6pFoL51KmdwT/wwJ1+rPmkrw7eb3b2SFqR\r\n" + 
            "SQvRuOCk4Z7Wtg8HRONdA2A/2G+8BQdEXNSJkbrf9X8er+fxqmR1Xf5Xc//nFroy\r\n" + 
            "ysUBguCvNtD/kUGLcW2iNjMxKoxbA+WTNojLTnXivaNooSEWNWfeHRzqjVzPinzz\r\n" + 
            "6DMKes9Gn2IHRRA1jgOwAdDiHJBuEdgnSjaTGqugbAB0kDIou9wx+eQDE2MXjPcv\r\n" + 
            "KjKurma65oaUJklG91ybP6txdLWVl/DQX7BXgHsXP3hYkTRx+UPT2Hqy4crKUV1u\r\n" + 
            "6o5j5ZECgYEA8pfpu+vJTyWcdShMHWLmwf63gZPOl846Yq7mcn/Q24vJ42Z8YM0v\r\n" + 
            "1rL8JhZV5WGgI5Ts0D3WVz4otF3ZcL9QGsCbjObd8AkFVz04Rqkmp1S+/nqa6DJm\r\n" + 
            "r091/1e4aekDKsFReMkmo/MOVKp86O7OA4fFVwi0193Z/9X7jvYQYBcCgYEA2whH\r\n" + 
            "KFEViaApEgsWKRQbovndrrjxWmwR2rTFSTdsryQUnNEVOTfCVxubdWIIxoMMM0IQ\r\n" + 
            "9yvdkX4Iaiw9dT7w1TuCZv3yYgxHkM3rv29kXQKYNjrULrd9IzQdr7cD5ovlFMH+\r\n" + 
            "X1ercJlHBKJrSRVRthI1jQjXV3CkmixNYGdfWSkCgYBawLPi5jlAD5zxQyr+T1Ju\r\n" + 
            "PmDd67J8ndy/sBhrux8iErBrDpr3B6ue0QR9JxvpHNVwmjThTlDSAGHv37AJerh3\r\n" + 
            "2ZgXZQKf2nASC8fyvzLDpHNy9eDffoNlj/9fj6xgipfxtbJJ0k5PRQ0WZVUnOrb9\r\n" + 
            "IRyVC5/Dpa35BE8AU1Ma7wKBgGez2qTvBwh7KRbe4uYeHBuku92+uJ78LdPj5MiO\r\n" + 
            "kkm2BoBcyfSmPsApVQhVmxwJ7dvS+t9cCHKbPnaubYa2fyYmH86Ni5X6hGO961Fe\r\n" + 
            "9yDGWrTKU62uuHPTd/664wDj2VljpAEWLBiKqcI6+BrJGj/fDTWyKuq+bWCFezka\r\n" + 
            "mF1JAoGBALmZFiUUhxGgt1LV8A6bEIHkfNKMnpU++ejabfYhjbYVohU8ygQZ8aB4\r\n" + 
            "6xObRob6K3tYqRgiiwOEjAWVVUMEbafaVXSteIXlkdIpL+tH0JXjgA1IESV09xmb\r\n" + 
            "f4wyK9IrofVCuq0WkIC5fRwEtSyQ0QsnT15fV4lFxoR/CG9T9LqC\r\n" + 
            "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAz4/NIWb6spcGZQc23MPL\r\n" + 
            "vWIo1NwDtAO/pLKptuPk5KDxRiSlIWDXpld3f8K2kjGc1B6X8dLTfNmhEI53mtq9\r\n" + 
            "5594QlJIQZx93zyZIPamA5t7WzlRaDg/Wdd7v8z98kERBuHFtFyTv0EWfs+3NSjm\r\n" + 
            "joqJBx+X67vRUbdwfiX5t5ttXXbK6DTAUe/LGrfN+1l94+rKmN5vBZ6118NmGGno\r\n" + 
            "1vZfd1YCCs1CfDWk9pwoEBzYqw146H6LGjOXELZTNIOVfidVXpReZ5VVRa5kWWMn\r\n" + 
            "92OUC7mkprP2PavUjaf007q/Q4LYMIcPIA25mN37o6RNdHsiqVthc3PJxtfOA5Bi\r\n" + 
            "rwIDAQAB\r\n" + 
            "-----END PUBLIC KEY-----";
}
