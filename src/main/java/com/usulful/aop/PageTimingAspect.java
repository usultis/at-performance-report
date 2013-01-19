package com.usulful.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.perf4j.StopWatch;
import org.perf4j.aop.AbstractJoinPoint;
import org.perf4j.aop.AbstractTimingAspect;
import org.perf4j.aop.Profiled;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;

@Aspect
public class PageTimingAspect extends AbstractTimingAspect {

    /**
     * This advice is used to add the StopWatch logging statements around method executions that have been tagged
     * with the Profiled annotation.
     *
     * @param pjp The ProceedingJoinPoint encapulates the method around which this aspect advice runs.
     * @return The return value from the method that was executed.
     * @throws Throwable Any exceptions thrown by the underlying method.
     */
    @Around(value = "execution(public !static * com.usulful..*Page.*(..))", argNames = "pjp")
    public Object doPerfLogging(final ProceedingJoinPoint pjp) throws Throwable {
        final String methodName = pjp.getSignature().getName();
        String tagName = tagName(pjp.getTarget().getClass().getSimpleName(), methodName);
        Profiled profiled = profiled(tagName);
        //We just delegate to the super class, wrapping the AspectJ-specific ProceedingJoinPoint as an AbstractJoinPoint
        return runProfiledMethod(
                new AbstractJoinPoint() {
                    public Object proceed() throws Throwable {
                        return pjp.proceed();
                    }

                    public Object getExecutingObject() {
                        return pjp.getThis();
                    }

                    public Object[] getParameters() {
                        return pjp.getArgs();
                    }

                    public String getMethodName() {
                        return methodName;
                    }
                },
                profiled,
                newStopWatch(profiled.logger() + "", profiled.level())
        );
    }

    private String tagName(final String claz, final String methodName) {
        return claz + "." + methodName;
    }

    private Profiled profiled(final String tagName) {
        return new Profiled() {

            @Override
            public String tag() {
                return tagName;
            }

            @Override
            public String message() {
                return "";
            }

            @Override
            public String logger() {
                return StopWatch.DEFAULT_LOGGER_NAME;
            }

            @Override
            public String level() {
                return "INFO";
            }

            @Override
            public boolean el() {
                return true;
            }

            @Override
            public boolean logFailuresSeparately() {
                return false;
            }

            @Override
            public long timeThreshold() {
                return 0;
            }

            @Override
            public boolean normalAndSlowSuffixesEnabled() {
                return false;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return Profiled.class;
            }
        };
    }

    protected Slf4JStopWatch newStopWatch(String loggerName, String levelName) {
        int levelInt = Slf4JStopWatch.mapLevelName(levelName);
        return new Slf4JStopWatch(LoggerFactory.getLogger(loggerName), levelInt, levelInt);
    }
}
