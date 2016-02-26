# Overview
This sample application tests JSR-303 validations for collections of beans.
It attempts to validate a raw collection of bean as well as a bean containing
a collection of other beans.

Two JSR-303 implementations are tested - Hibernate Validator and Apache Beans
Validator (BVal).

# Running the application
To run the application with Hibernate Validator

> mvn clean test -Phibernate

To run the application with Apache Beans Validator

> mvn clean test -Papache

# License
This sample application and its associated source code in its entirety is being made
available under the following licensing terms.

    Copyright (C) 2016

    Permission is hereby granted, free of charge, to any person obtaining a copy of
    this software and associated documentation files (the "Software"), to deal in the
    Software without restriction, including without limitation the rights to use, copy,
    modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
    and to permit persons to whom the Software is furnished to do so, subject to the
    following conditions:

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
    PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
    HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
    CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
    OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
