package functionthinks.memoiztion

import org.junit.Test

import static junit.framework.Assert.assertTrue
/**
 * (probably) Copyright 2011 by Neal Ford. All rights reserved.
 */
class ClassifierTest {
  def classifierSum = new ClassifierCachedSum()
  def start;
  
  @Test
  void classifies_correctly() {
    assertTrue(classifierSum.isPerfect(6))
    assertTrue(classifierSum.isPerfect(496))
    assertTrue(classifierSum.isPerfect(8128))
    assertTrue(classifierSum.isAbundant(24))
    assertTrue(classifierSum.isDeficient(7))
  }

  @Test
  void optimizations() {

  }

// BEGIN groovy_uncached_sum
  def static final TEST_NUMBER_MAX = 2000

  @Test
  void mashup() {
    println "Test for range 1-${TEST_NUMBER_MAX}"

// BEGIN groovy_cached_sum
    def classifier = new ClassifierCachedSum()
    print "Cached sum:                 "
    def start = System.currentTimeMillis()
    (1..TEST_NUMBER_MAX).each {n ->
      if (classifier.isPerfect(n)) print '!'
      else if (classifier.isAbundant(n)) print '+'
      else if (classifier.isDeficient(n)) print '-'
    }
    println "\n\t ${System.currentTimeMillis() - start} ms"
    print "Cached sum (2nd run):       "
    start = System.currentTimeMillis()
    (1..TEST_NUMBER_MAX).each {n ->
      if (classifier.isPerfect(n)) print '!'
      else if (classifier.isAbundant(n)) print '+'
      else if (classifier.isDeficient(n)) print '-'
    }
    println "\n\t ${System.currentTimeMillis() - start} ms"
// END groovy_cached_sum

// BEGIN groovy_cached_fully
    print "Cached:                     "
    def classifierFullyCached = new ClassifierCached()
    start = System.currentTimeMillis()
    (1..TEST_NUMBER_MAX).each {n ->
      if (classifierFullyCached.isPerfect(n)) print '!'
      else if (classifierFullyCached.isAbundant(n)) print '+'
      else if (classifierFullyCached.isDeficient(n)) print '-'
    }
    println "\n\t ${System.currentTimeMillis() - start} ms"
    print "Cached (2nd run):           "
    start = System.currentTimeMillis()
    (1..TEST_NUMBER_MAX).each {n ->
      if (classifierFullyCached.isPerfect(n)) print '!'
      else if (classifierFullyCached.isAbundant(n)) print '+'
      else if (classifierFullyCached.isDeficient(n)) print '-'
    }
    println "\n\t ${System.currentTimeMillis() - start} ms"
// END groovy_cached_fully

  }

  @Test
  void PartiallyMemoized() {
    println "Test for range 1-${TEST_NUMBER_MAX}"

// BEGIN groovy_partially_memoized
    print "Partially Memoized:         "
    start = System.currentTimeMillis()
    (1..TEST_NUMBER_MAX).each {n ->
      if (ClassifierMemoizedSum.isPerfect(n)) print '!'
      else if (ClassifierMemoizedSum.isAbundant(n)) print '+'
      else if (ClassifierMemoizedSum.isDeficient(n)) print '-'
    }
    println "\n\t ${System.currentTimeMillis() - start} ms"
    print "Partially Memoized (2nd):   "
    start = System.currentTimeMillis()
    (1..TEST_NUMBER_MAX).each {n ->
      if (ClassifierMemoizedSum.isPerfect(n)) print '!'
      else if (ClassifierMemoizedSum.isAbundant(n)) print '+'
      else if (ClassifierMemoizedSum.isDeficient(n)) print '-'
    }
    println "\n\t ${System.currentTimeMillis() - start} ms"

    print "Memoized:                   "
    start = System.currentTimeMillis()
    (1..TEST_NUMBER_MAX).each {n ->
      if (ClassifierMemoized.isPerfect(n)) print '!'
      else if (ClassifierMemoized.isAbundant(n)) print '+'
      else if (ClassifierMemoized.isDeficient(n)) print '-'
    }
    println "\n\t ${System.currentTimeMillis() - start} ms"
    print "Memoized(2nd)               "
    start = System.currentTimeMillis()
    (1..TEST_NUMBER_MAX).each {n ->
      if (ClassifierMemoized.isPerfect(n)) print '!'
      else if (ClassifierMemoized.isAbundant(n)) print '+'
      else if (ClassifierMemoized.isDeficient(n)) print '-'
    }
    println "\n\t ${System.currentTimeMillis() - start} ms"
// END groovy_partially_memoized

  }
}
