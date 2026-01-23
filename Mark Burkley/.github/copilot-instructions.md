# Copilot Instructions for Signal Handling Codebase

## Project Overview
This is an educational project demonstrating signal handling in C and shell scripting. It contains examples of:
- **Signal handlers**: Custom handlers for SIGSEGV and signal ignoring patterns
- **Shell script integration**: Wrapper scripts for C programs with exit code parsing

## Key Files and Patterns

### Core C Programs
- **SIGSEGVHandler.c**: Demonstrates custom signal handler setup using `signal()` API. Catches SIGSEGV, prints diagnostic message, and exits gracefully.
- **IgnoreSignals.c**: Shows signal ignoring with `SIG_IGN` for SIGINT and SIGTERM, enters infinite `pause()` loop for testing.
- **3.1.c**: Simple command-line argument validator using `strcmp()` for "secret" string matching, returns exit codes (0=match, 1=no match, 2=no args).

### Build & Test Patterns
- **3.2.sh**: Shell wrapper that executes `./check` binary (compiled from 3.1.c), interprets exit codes as success/failure, and outputs human-readable messages.
  - Exit code 0 → "Match"
  - Exit code 1 → "No match"
  - Any other → "No parameter"

## Critical Workflows

### Compilation
Compile C files with gcc (standard POSIX signals require `<signal.h>`):
```bash
gcc -o check 3.1.c
gcc -o sighandler SIGSEGVHandler.c
gcc -o ignore IgnoreSignals.c
```

### Testing Signal Handlers
- **SIGSEGV test**: Run `./sighandler` - deliberately dereferences NULL pointer, handler catches it
- **Signal ignoring test**: Run `./ignore`, then send signals (`kill -INT <pid>`, `kill -TERM <pid>`) - will not terminate

### Exit Code Convention
This codebase uses exit codes as a primary communication mechanism:
- 0 = success/match
- 1 = failure/no match  
- 2 = error/missing input

The shell wrapper (3.2.sh) always parses these codes to provide user-friendly output.

## Code Patterns to Follow

1. **Signal Handlers**: Must be simple and async-signal-safe. Avoid printf/malloc in production code (SIGSEGVHandler.c uses printf for educational purposes only).
2. **Exit Codes**: Always use meaningful exit codes—this codebase treats them as the primary error reporting mechanism.
3. **Command-line Parsing**: Use standard library functions like `strcmp()` for argument validation before business logic.

## Compilation Platform Notes
These are POSIX C programs. On Windows, compile with MinGW or use WSL. Signal handling behavior may differ between platforms.
