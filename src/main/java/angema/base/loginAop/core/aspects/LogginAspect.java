package angema.base.loginAop.core.aspects;

import java.util.Arrays;

import angema.base.loginAop.core.logs.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * * @author Hugo Gerard Palet 1/11/2021
 **/

@Aspect
@Component
class LoggingAspect {

    @Autowired
    private LogService logService;

    /**
     * Pointcut that matches all repositories, services and Web REST endpoints.
     */
    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)" +
            " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Pointcut that matches all Spring beans in the application's main packages.
     */
    @Pointcut("within(angema.base.logsAop.app.registros..*)" +
            " || within(angema.base.logsAop.app.ventas..*)" )
    public void applicationPackagePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Advice that logs methods throwing exceptions.
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logService.errorLog(e.getCause() != null ? String.valueOf(e.getCause()) : "NULL");
    }

    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
    @Around("applicationPackagePointcut() && springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (logService.isDebugEnabled()) {
            if(joinPoint.getSignature().getDeclaringTypeName().contains("Controller")) {
                logService.initLog(joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
            } else {
                logService.processLog(joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
            }
        }
        try {
            Object result = joinPoint.proceed();
            if (logService.isDebugEnabled()) {
                if(joinPoint.getSignature().getDeclaringTypeName().contains("Controller")) {
                    logService.endLog();
                } else {
                    logService.processLog(joinPoint.getSignature().getDeclaringTypeName(),
                            joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
                }
            }
            return result;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
